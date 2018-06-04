package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.dto.FruitsDto;

public class FruitsDao {

	private static final String DB_URL = "jdbc:mysql://localhost/maven_sample?useSSL=false";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "admin";

	public List<FruitsDto> findAll() {
		try (
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement st = con.createStatement()
		) {
			ResultSet rs = st.executeQuery("select * from fruits");
			List<FruitsDto> fruitsList = new ArrayList<>();
			while(rs.next()){
				FruitsDto fruitsDto = new FruitsDto();
				fruitsDto.setId(rs.getInt("id"));
				fruitsDto.setName(rs.getString("name"));
				fruitsDto.setPrice(rs.getInt("price"));
				fruitsList.add(fruitsDto);
			}
			return fruitsList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public FruitsDto selectById (int id) {
		String sql = "select * from fruits where id = ?";
		try (
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement ps = con.prepareStatement(sql)
		) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			FruitsDto fruitsDto = null;
			while (rs.next()) {
				fruitsDto = new FruitsDto();
				fruitsDto.setId(rs.getInt("id"));
				fruitsDto.setName(rs.getString("name"));
				fruitsDto.setPrice(rs.getInt("price"));
			}
			return fruitsDto;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
