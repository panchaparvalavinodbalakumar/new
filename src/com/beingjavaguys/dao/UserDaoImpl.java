package com.beingjavaguys.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.beingjavaguys.domain.EquipmentMaster;
import com.beingjavaguys.domain.EquipmentType;
import com.beingjavaguys.domain.Facility;
import com.beingjavaguys.domain.User;
import com.beingjavaguys.jdbc.FacilityMasterRowMapper;
import com.beingjavaguys.jdbc.FacilityRowMapper;
import com.beingjavaguys.jdbc.UserRowMapper;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource dataSource;

/*	public void insertData(User user) {

		String sql = "INSERT INTO user "
				+ "(first_name,last_name, gender, city) VALUES (?, ?, ?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getGender(), user.getCity() });

	}*/
	public void insertData(User user) {

		System.out.println("entering in to query"+user);
		String sql = "INSERT INTO Equipment_Master"
				+ "( Equipment_Id,Equipment_Type_Name,Equipment_Name,S_NO,Description,Reg_No,Start_Date,End_Date,Facility_Name) VALUES (? , ? , ? , ? , ? , ? , ? , ? , ?)";
		
		user.setEquipment_Type_Name("testOne");
			
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getEquipment_Id(),user.getEquipment_Type_Name(),user.getEquipment_Name(),
						user.getS_NO(),user.getDescription(),user.getReg_No(),user.getStart_Date(),user.getEnd_Date(),user.getFacility_Name()});

	}

	public List<User> getUserList() {
		System.out.println("First Enter");
		List userList = new ArrayList();
		System.out.println("First Enter 2");
		String sql = "select * from Equipment_Master";
		System.out.println("First Enter 3");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("First Enter 4");
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		System.out.println("First Enter 5");
		return userList;
		
	}

	@Override
	public void deleteData(String id) {
		String sql = "delete from user where user_id=" + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	/*@Override
	public void updateData(User user) {

		String sql = "UPDATE user set first_name = ?,last_name = ?, gender = ?, city = ? where user_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getGender(), user.getCity(), user.getUserId() });

	}*/
	//retrive data from euipment master

	@Override
	public User getUser(String id) {
		List<User> userList = new ArrayList<User>();
		String sql = "select * from Equipment_Master";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList.get(0);
	}

	@Override
	public List<EquipmentType> getEquipmentTypeList() {
		List userList = new ArrayList();
		String sql = "select * from Equipment_Type_Master";
		System.out.println("SQL result: "+sql);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new FacilityRowMapper());
		System.out.println("userList: "+userList);
		return userList;
	}

	
//method to insert data in to equipment master
	@Override
	public void insertEquipment(EquipmentMaster em) {
		System.out.println("entering in to query"+em);
		String sql = "INSERT INTO Equipment_Master"
				+ "( Equipment_Id,Equipment_Type_Name,Equipment_Name,S_NO,Reg_No,Description,Start_Date,End_Date,Facility_Name) VALUES (?,?,?,?,?,?,?,?,?)";
		
		em.setEquipment_Type_Name("testOne");
			
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { em.getEquipment_Id(),em.getEquipment_Type_Name(), em.getEquipment_Name(),
						em.getS_NO(),em.getReg_No(), em.getDescription(),em.getStart_Date(),em.getEnd_Date(),em.getFacility_Name()});
		
	}

	@Override
	public List<Facility> getFacilityMasterList() {
		List facilityList = new ArrayList();
		   String sql = "select * from Facility_Master";
		   System.out.println("SQL result: "+sql);
		   JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		   facilityList = jdbcTemplate.query(sql, new FacilityMasterRowMapper());
		   System.out.println("userList: "+facilityList);
		   return facilityList;

	}

	@Override
	public void updateData(User user) {
		// TODO Auto-generated method stub
		
	}

}
