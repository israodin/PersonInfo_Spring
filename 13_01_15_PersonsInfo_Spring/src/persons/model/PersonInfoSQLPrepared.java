package persons.model;

import java.sql.*;
import java.util.*;


@SuppressWarnings("serial")
public class PersonInfoSQLPrepared extends CommonSQLmethods implements PersonsInfoModel {
	private static String USER="roowt";
	private static String PASSWORD ="123456";
	private static String URL="jdbc:mysql://localhost/test";

	private PreparedStatement stGetPersonId;
	private PreparedStatement stAddPersonId;
	private PreparedStatement stGetPersonsYear;
	private PreparedStatement stGetPersonsName;
	private PreparedStatement stRemovePersonId;
	
	public PersonInfoSQLPrepared(String URL, String USER, String PASSWORD)	throws Exception {
		super(URL, USER, PASSWORD);
		preparedStatements();

	}
	public PersonInfoSQLPrepared() throws Exception {
		super(URL, USER, PASSWORD);
		preparedStatements();
	}



	private void preparedStatements() throws SQLException{
		stGetPersonId=connection.prepareStatement
				("SELECT * FROM Person WHERE id=?");
		stRemovePersonId=connection.prepareStatement
				("DELETE FROM Person WHERE id=?");
		stGetPersonsName=connection.prepareStatement
				("SELECT * FROM Person WHERE name=?");
		stGetPersonsYear=connection.prepareStatement
				("SELECT * FROM Person WHERE birthYear BETWEEN ? AND ?");
		stAddPersonId=connection.prepareStatement
				("INSERT INTO Person (id,name,birthYear) VALUES (?,?,?)");

	}

	@Override
	public boolean addPerson(Person person) {
		boolean res=true;

		try {
			stAddPersonId.setInt(1, person.getId());
			stAddPersonId.setString(2, person.getName());
			stAddPersonId.setInt(3, person.getBirthYear());
			stAddPersonId.executeUpdate();
		} catch (SQLException e) {
			res=false;
		}
		return res;
	}



	@Override
	public Person getPersonId(int id) {
		Person person=null;
		List<Person> res=new ArrayList<Person>();
		try {
			stGetPersonId.setInt(1, id);
			getPersons(stGetPersonId,res);
			if(!res.isEmpty()){
				person=res.get(0);
			}

		} catch (SQLException e) {

		}
		return person;
	}

	@Override
	public List<Person> getPersonsYears(int minYear, int maxYear) {
		List<Person> res=new ArrayList<Person>();
		try {
			stGetPersonsYear.setInt(1, minYear);
			stGetPersonsYear.setInt(2, maxYear);
			getPersons(stGetPersonsYear,res);
		} catch (SQLException e) {

		}

		return res;
	}
        
	private void getPersons(PreparedStatement statement,
			List<Person> res) {
		ResultSet rs;
		try {
			rs = statement.executeQuery();
			while (rs.next()) {
				String name=rs.getString("name");
				int id=rs.getInt("id");
				int birthYear=rs.getInt("birthYear");
				Person prs=new Person(id,name,birthYear);
				res.add(prs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public List<Person> getPersonsName(String name) {
		List<Person> res=new ArrayList<Person>();
		try {
			stGetPersonsName.setString(1, name);
			getPersons(stGetPersonsName,res);
		} catch (SQLException e) {

		}
		return res;
	}

	@Override
	public boolean removePerson(int id) {
		boolean res=true;
		try {
			stRemovePersonId.setInt(1, id);
			stRemovePersonId.executeUpdate();
		} catch (SQLException e) {
			res=false;
		}
		return res;
	}

}
