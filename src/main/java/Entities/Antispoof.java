package Entities;

import lombok.Data;

import java.util.List;

@Data
public class Antispoof {

    private String username;

    private String normalized;

    private String result;

    private List<String> users;


}
