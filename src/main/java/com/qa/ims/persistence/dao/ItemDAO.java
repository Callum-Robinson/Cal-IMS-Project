package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;

public class ItemDAO implements Dao<Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public List<Item> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item create(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item update(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String type = resultSet.getString("type");
		String name = resultSet.getString("name");
		String description = resultSet.getString("description");
		Float cost = resultSet.getFloat("cost");
		return new Item(id, type, name, description, cost);
	}
	
	
}
