package com.udacity.course3.repository;

import com.udacity.course3.data.CandyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CandyDAOImpl implements CandyDAO{

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public static final String SELECT_ALL_CANDIES = "select * from candy";
    public static final String INSERT_DELIVERY = "insert into candy_delivery(candy_id, delivery_id) " +
            "values(:candyId, :deliveryId)";
    public static final String SELECT_CANDIES_FOR_DELIVERY = "select c.* from candy as c join candy_delivery as cd " +
            "on c.id = cd.candy_id where cd.delivery_id = :deliveryId";

    private static final RowMapper<CandyData> candyDataRowMapper =
            new BeanPropertyRowMapper<>(CandyData.class);

    @Override
    public List<CandyData> getAllCandies() {
        return jdbcTemplate.query(SELECT_ALL_CANDIES, candyDataRowMapper);
    }

    @Override
    public void addCandyToDelivery(Long candyId, Long deliveryId) {
        jdbcTemplate.update(INSERT_DELIVERY,
                new MapSqlParameterSource().addValue("candyId", candyId)
                                           .addValue("deliveryId", deliveryId));
    }

    @Override
    public List<CandyData> getCandiesForDelivery(Long deliveryId) {
        return jdbcTemplate.query(SELECT_CANDIES_FOR_DELIVERY,
                new MapSqlParameterSource().addValue("deliveryId", deliveryId),
                candyDataRowMapper);
    }
}
