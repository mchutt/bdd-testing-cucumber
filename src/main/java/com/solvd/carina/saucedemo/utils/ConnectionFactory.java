package com.solvd.carina.saucedemo.utils;

import java.io.IOException;
import java.io.Reader;

import com.solvd.carina.saucedemo.mappers.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConnectionFactory {
    private static SqlSessionFactory factory;

    public static final String MYBATIS_CONFIG_XML = "mybatis-config.xml";

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(MYBATIS_CONFIG_XML);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }

    public static UserMapper getUserMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(UserMapper.class);
    }
}
