package br.com.alura.listavip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class Configuracao
{
    public static void main(String[] args)
    {
        SpringApplication.run(Configuracao.class, args);
    }

}

