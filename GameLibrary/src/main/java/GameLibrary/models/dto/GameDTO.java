package GameLibrary.models.dto;

public class GameDTO {

    private Long id; 
    private String title; 
    private String genre; 
    private String platform;

    public GameDTO(Long id, String title, String genre, String platform){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.platform = platform;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
