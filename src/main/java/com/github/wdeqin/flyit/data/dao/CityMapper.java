package com.github.wdeqin.flyit.data.dao;

import com.github.wdeqin.flyit.data.model.City;

public interface CityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbggenerated Thu Sep 01 21:43:58 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbggenerated Thu Sep 01 21:43:58 CST 2016
     */
    int insert(City record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbggenerated Thu Sep 01 21:43:58 CST 2016
     */
    int insertSelective(City record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbggenerated Thu Sep 01 21:43:58 CST 2016
     */
    City selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbggenerated Thu Sep 01 21:43:58 CST 2016
     */
    int updateByPrimaryKeySelective(City record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbggenerated Thu Sep 01 21:43:58 CST 2016
     */
    int updateByPrimaryKey(City record);
}