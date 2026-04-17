package GameLibrary.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    private Long id; 
    private String title; 
    private String genre; 
    private String platform;
}