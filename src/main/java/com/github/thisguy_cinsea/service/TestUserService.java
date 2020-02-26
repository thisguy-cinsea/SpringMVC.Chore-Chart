//package com.github.thisguy_cinsea.service;
//
//import com.github.thisguy_cinsea.dao.UserDao;
//import com.github.thisguy_cinsea.model.UserInterface;
//import com.github.thisguy_cinsea.model.User;
//import com.github.thisguy_cinsea.utils.jdbc.DBConnection;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class UserService implements UserDao {
//    private final DBConnection dbc;
//
//    public UserService(DBConnection dbc) {
//        this.dbc = dbc;
//    }
//
//    public UserService() {
//        this(DBConnection.CHORE_CHART_DB);
//    }
//
//    public Map<String, UserInterface> getAllUsers(){
//        String sqlQuery = "SELECT * from user_tbl;";
//        ResultSet resultSet = dbc.executeQuery(sqlQuery);
//        Map<String, UserInterface> list = new HashMap<>();
//        try{
//            while (resultSet.next()){
//                UserInterface user = new UserBuilder()
//                        .setFirstName(resultSet.getString("firstName"))
//                        .setLastName(resultSet.getString("lastName"))
//                        .setEmail(resultSet.getString("email"))
//                        .setPassword(hashPassword(resultSet.getString("password")))
//                        .build();
//                user.setUserId(resultSet.getString("userId"));
//                list.put(resultSet.getString("userId"), user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<UserInterface> listAllUsers(){
//        String sqlQuery = "SELECT * from user_tbl;";
//        ResultSet resultSet = dbc.executeQuery(sqlQuery);
//        List<UserInterface> list = new ArrayList<>();
//        try{
//            while (resultSet.next()){
//                UserInterface user = new UserBuilder()
//                        .setFirstName(resultSet.getString("firstName"))
//                        .setLastName(resultSet.getString("lastName"))
//                        .setEmail(resultSet.getString("email"))
//                        .setPassword(hashPassword(resultSet.getString("password")))
//                        .build();
//                user.setUserId(resultSet.getString("userId"));
//                list.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    @Override
//    public UserInterface createUser(User user) {
//        UserInterface userToCreate = new UserBuilder()
//                .setFirstName(user.getFirstName())
//                .build();
//        String sqlStatement = "INSERT INTO user_tbl ( userId, firstName) VALUES (" +
//                "'" + userToCreate.getUserId() +"'," +
//                "'" + userToCreate.getFirstName() +"');";
//        dbc.executeStatement(sqlStatement);
//        return userToCreate;
//    }
//
//    private String hashPassword(String plainTextPassword){
//        return new BCryptPasswordEncoder().encode(plainTextPassword);
//    }
//
//    public UserInterface getUserByEmail(String userEmail){
//        String sqlQuery = "SELECT * from user_tbl WHERE `email` = '"+ userEmail + "';";
//        ResultSet resultSet = dbc.executeQuery(sqlQuery);
//        try{
//            while (resultSet.next()){
//                UserInterface user = new UserBuilder()
//                        .setFirstName(resultSet.getString("firstName"))
//                        .setLastName(resultSet.getString("lastName"))
//                        .setEmail(resultSet.getString("email"))
//                        .setPassword(resultSet.getString("password"))
//                        .build();
//                user.setUserId(resultSet.getString("userId"));
//                return user;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public UserInterface registerUser(User user) {
////        System.out.println("user: " + user);
////        if (getUserByEmail(user.getEmail()) == null) {
////            System.out.println("not null " );
////            UserInterface userToRegister = new UserBuilder()
////                    .setFirstName(user.getFirstName())
////                    .setLastName(user.getLastName())
////                    .setEmail(user.getEmail())
////                    .setPassword(hashPassword(user.getPassword()))
////                    .build();
////            System.out.println("userToRegister: " + userToRegister);
////            String sqlStatement = "INSERT INTO user_tbl ( userId, firstName, lastName, email, password) VALUES (" +
////                    "'" + userToRegister.getUserId() +"'," +
////                    "'" + userToRegister.getFirstName() +"'," +
////                    "'" + userToRegister.getLastName() +"'," +
////                    "'" + userToRegister.getEmail() +"'," +
////                    "'" + userToRegister.getPassword() +"');";
////            dbc.executeStatement(sqlStatement);
////            return userToRegister;
////        }
//        System.out.println("User already in system");
//        return null;
//    }
//
//    @Override
//    public UserInterface getUserById(String userId) {
//        return getAllUsers().getOrDefault(userId, null);
//    }
//}
