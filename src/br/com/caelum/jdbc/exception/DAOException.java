package br.com.caelum.jdbc.exception;

public class DAOException extends RuntimeException {
    public DAOException(Throwable couse){
        super(couse);
    }
    
    
}
