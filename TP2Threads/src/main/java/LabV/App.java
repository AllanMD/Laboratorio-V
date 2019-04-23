package LabV;

import LabV.database.Database;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Date fecha = new Date();
        java.sql.Date fecha2 = new java.sql.Date(fecha.getTime());
        Database.insertWinner("Allan",  fecha2,"River" );
    }
}
