/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author dab18
 */
public class Query {
    	public static String GET_BONUS = "{? = call obtenerAguinaldo(?)}";
        public static String GET_TOTAL_SALARY = "{? = call totalSalarios(?, ?)}";
        public static String GET_EMPLOYEE_NAME = "{? = call getEmpleadoName(?)}";
        public static String GET_NET_TOTAL_OBLIGATION = 
                    "{call totalNetoObligaciones(?, ?)}";
        public static String GET_TOP10_EMPLOYEE = "{? = call callTop10Empleados(?,?)}";
        public static String GET_ASC_INFO = "{call infoPlantas3}";
        public static String GET_DESC_INFO = "{call infoPlantas2}";
        public static String GET_BY_PLANT_INFO = "{call infoPlantas1}";
        public static String GET_EMPLOYEE_HISTORIC = "{? = call historicoEmpleado(?)}";
        public static String HISTORIC_EMPLOYEE = "{call historicoEmpleado(?)}";
        public static String GET_PLANTS_IDS = "{call getIdPlants}";
        public static String HISTORIC_PLANT = "{call historicoPlanta(?)}";
        public static String QUERY_PLANILLA = "{call getPlanillasSinPagar}";
        
                
        
        private Connection connection;
        
        public Query() {}
        
        /**
         * Gets the Bonus of a Employee, from the database of Corporation
         * @param _id int, ID of the wanted employee bonus
         * @return returns the bonus, from a sql function
         */
        public float getBonus(int _id) {
            connection = DBConnection.getInstance().connect();
            CallableStatement statement;
            float result = -1;
            try {
                statement = connection.prepareCall(GET_BONUS);
                statement.setString(2,Integer.toString(_id));
                statement.registerOutParameter(1, java.sql.Types.FLOAT);  
                statement.execute();   

                result = statement.getFloat(1);
                System.out.println("The result is: " + result);
                
                
            } catch (SQLException | NullPointerException e) {
                System.err.println("No se pudo realizar la consulta"); 
                System.err.println(e.getMessage());

            } finally {
		DBConnection.getInstance().disconnect();
		}
            return result;
        }   
        /**
         * Gets the total salary paid by the Corporation in a certain period of time
         * @param inicialD Inicial Date, Date
         * @param finalD Final Date, Date
         * @return returns the amount (float) paid, given by SQL function
         */
        public ResultSet getTotalSalary(String _id) {
            connection = DBConnection.getInstance().connect();
            CallableStatement statement;
            ResultSet result = null;
            try {
                statement = connection.prepareCall(GET_EMPLOYEE_HISTORIC);
                statement.setString(2,_id);
                statement.registerOutParameter(1, java.sql.Types.OTHER);  
                //statement.execute();   

                result = statement.executeQuery();
               
                
                
            } catch (SQLException | NullPointerException e) {
                System.err.println("No se pudo realizar la consulta"); 
                System.err.println(e.getMessage());

            } finally {
		//DBConnection.getInstance().disconnect();
		}
            return result;
        }
        
        public ResultSet getTotalOblig(java.util.Date iniD, java.util.Date finD) {
            connection = DBConnection.getInstance().connect();
            CallableStatement statement;
            String result = "";
            ResultSet rs = null;
            try {
                statement = connection.prepareCall(GET_NET_TOTAL_OBLIGATION);
                statement.setDate(1, convertUtilToSql(iniD));
                statement.setDate(2, convertUtilToSql(finD));
                rs = statement.executeQuery();
                
      
                //print a header row
                /*result += "\nTotalNeto\t|\tTotalObligaciones \t";
                result += "----------------------\t|\t----------------\t";
      
                //loop through the result set and call method to print the result set row
                while (rs.next()){
                    String TotalNet= rs.getString("Total_Neto");
                    String TotalOblg= rs.getString("Total_Obligaciones");
                    result += "\n" + TotalNet + "\t|\t" + TotalOblg + "\t|\t";
                } */
                
            } catch (SQLException | NullPointerException e) {
                System.err.println("No se pudo realizar la consulta"); 
                System.err.println(e.getMessage());

            } finally {
		//DBConnection.getInstance().disconnect();
		}
            return rs;
        }
        public ResultSet getHistEmployee(int _idEmployee) {
            connection = DBConnection.getInstance().connect();
            CallableStatement statement = null;
            String result = "";
            ResultSet rs = null;
            try {
                statement = connection.prepareCall(HISTORIC_EMPLOYEE);
                statement.setInt(1, _idEmployee);
                rs = statement.executeQuery();
                
            } catch (SQLException | NullPointerException e) {
                System.err.println("No se pudo realizar la consulta :("); 
                System.err.println(e.getMessage());
            }        
            return rs;
        
        }
        
        public ResultSet getHistPlant(int _idPlant) {
            connection = DBConnection.getInstance().connect();
            CallableStatement statement = null;
            String result = "";
            ResultSet rs = null;
            try {
                statement = connection.prepareCall(HISTORIC_PLANT);
                statement.setInt(1, _idPlant);
                rs = statement.executeQuery();
                
            } catch (SQLException | NullPointerException e) {
                System.err.println("No se pudo realizar la consulta :("); 
                System.err.println(e.getMessage());
            }        
            return rs;
        
        }
        public ResultSet getPlants(){
            connection = DBConnection.getInstance().connect();
            CallableStatement statement = null;
            String result = "";
            ResultSet rs = null;
            try {
                statement = connection.prepareCall(GET_PLANTS_IDS);
                //statement.setInt(1, _idEmployee);
                rs = statement.executeQuery();
                
            } catch (SQLException | NullPointerException e) {
                System.err.println("No se pudo realizar la consulta :("); 
                System.err.println(e.getMessage());
            }        
            return rs;
            
        }
        public String getEmployeeName(int id){
            connection = DBConnection.getInstance().connect();
            CallableStatement statement;
            String result = "";
            try {
                
                statement = connection.prepareCall(GET_EMPLOYEE_NAME);
               
                
                 statement.setString(2,Integer.toString(id));
                statement.registerOutParameter(1, java.sql.Types.NVARCHAR);  
                statement.execute();   

                result = statement.getString(1);
                System.out.println("El nombre del empleado es: " + result);
                
                
      

                
            } catch (SQLException | NullPointerException e) {
                System.err.println("No se pudo realizar la consulta"); 
                System.err.println(e.getMessage());

            } finally {
		DBConnection.getInstance().disconnect();
		}
            return result;
            
        }
        
        public String getTotalSalaryName(int id){
            connection = DBConnection.getInstance().connect();
            CallableStatement statement;
            String result = "";
            try {
                
                statement = connection.prepareCall(GET_EMPLOYEE_NAME);
               
                
                 statement.setString(2,Integer.toString(id));
                statement.registerOutParameter(1, java.sql.Types.NVARCHAR);  
                statement.execute();   

                result = statement.getString(1);
                System.out.println("El nombre del empleado es: " + result);
                
                
      

                
            } catch (SQLException | NullPointerException e) {
                System.err.println("No se pudo realizar la consulta"); 
                System.err.println(e.getMessage());

            } finally {
		DBConnection.getInstance().disconnect();
		}
            return result;
            
        }
        
        public ResultSet getTop10Employees(java.util.Date iniD, java.util.Date finD) {
            connection = DBConnection.getInstance().connect();
            CallableStatement statement;
            String result = "";
            ResultSet rs = null;
            try {
                statement = connection.prepareCall(GET_TOP10_EMPLOYEE);
                statement.registerOutParameter(1, java.sql.Types.OTHER);
                statement.setDate(2, convertUtilToSql(iniD));
                statement.setDate(3, convertUtilToSql(finD));
                rs = statement.executeQuery();

                //print a header row
                /*result += "\nNombreEmpleado\t|\tSalario Total";
                result += "----------------------\t|\t----------------\t";
      
                //loop through the result set and call method to print the result set row
                while (rs.next()){
                    String name= rs.getString("nombre");
                    String total_salary= rs.getString("Salario Total");
                    result += "\n" + name + "\t|\t" + total_salary;
                } */
                
            } catch (SQLException | NullPointerException e) {
                System.err.println("No se pudo realizar la consultaAA"); 
                System.err.println(e.getMessage());

            } finally {
		//DBConnection.getInstance().disconnect();
		}
            return rs;
        }
        
        public ResultSet getPlanillas() {
            connection = DBConnection.getInstance().connect();
            CallableStatement statement = null;
            String result = "";
            ResultSet rs=null;
            
            
            
            
            try {
                statement = connection.prepareCall(QUERY_PLANILLA);
                rs = statement.executeQuery();
                

                
            } catch (SQLException | NullPointerException e) {
                System.err.println("No se pudo realizar la consulta :c"); 
                System.err.println(e.getMessage());

            } finally {
		//DBConnection.getInstance().disconnect();
		}
            //return result;
            //System.out.println(result);
            return rs;
        }
        
        public ResultSet getPlantInfo(PlantInfo _type) {
            connection = DBConnection.getInstance().connect();
            CallableStatement statement = null;
            String result = "";
            ResultSet rs=null;
            try {
                switch (_type) {
                    case ASCENDANT:
                        statement = connection.prepareCall(GET_ASC_INFO);
                        break;
                    case DESCENDANT:
                        statement = connection.prepareCall(GET_DESC_INFO);
                        break;
                    case BY_PLANT:
                        statement = connection.prepareCall(GET_BY_PLANT_INFO);
                        break;
                }
                
                rs = statement.executeQuery();
                /*
                //print a header row
                result += "\nidPlanta\t|\tTotal Empleados\t|\tTotal salarios brutos\t|\tPromedio salarios brutos";
                result += "----------------------\t|\t----------------\t";
      
                //loop through the result set 
                while (rs.next()){
                    String idplant = rs.getString("id_planta");
                    String totalEmplyee= rs.getString("Total Empleados");
                    String totalSB = rs.getString("Total salarios brutos");
                    String sbAvg = rs.getString("Promedio salarios brutos");
                    result += "\n" + idplant + "\t|\t" + totalEmplyee + "\t|\t" + totalSB + "\t|\t" +sbAvg ;
                } */
                
            } catch (SQLException | NullPointerException e) {
                System.err.println("No se pudo realizar la consulta :("); 
                System.err.println(e.getMessage());

            } finally {
		//DBConnection.getInstance().disconnect();
		}
            //return result;
            //System.out.println(result);
            return rs;
        }
        
        
        private static String convertDateToString(java.util.Date uDate) {
            java.sql.Date sDate = new java.sql.Date(uDate.getTime());
            //return sDate;
            DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
            return df.format(uDate);
        }
        
        private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
            java.sql.Date sDate = new java.sql.Date(uDate.getTime());
            return sDate;
        }

        
}