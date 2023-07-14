package mod12les2t2.data;

import mod12les2t1.data.Director;

import java.sql.Date;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private Date release;
    private Director director;

    public Movie(int id, String title, String genre, Date release, Director director) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.release = release;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Date getRelease() {
        return release;
    }

    public Director getDirector() {
        return director;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Movie)) {
            return false;
        }

        Movie anothermovie = (Movie) object;

        if (this.id == anothermovie.getId()
                && this.title.equals(anothermovie.getTitle())
                && this.genre.equals(anothermovie.getGenre())
                && this.release.equals(anothermovie.getRelease())
                && this.director.equals(anothermovie.getDirector())) {
            System.out.println(this.id + " " +  anothermovie.getId());
            System.out.println(this.title + " " +  anothermovie.getTitle());
            System.out.println(this.genre + " " +  anothermovie.getGenre());
            System.out.println(this.release + " " +  anothermovie.getRelease());
            System.out.println(this.director + " " +  anothermovie.getDirector());
            return true;
        }
        else {
            System.out.println(this.id + " " +  anothermovie.getId());
            System.out.println(this.title + " " +  anothermovie.getTitle());
            System.out.println(this.genre + " " +  anothermovie.getGenre());
            System.out.println(this.release + " " +  anothermovie.getRelease());
            System.out.println(this.director + " " +  anothermovie.getDirector());
            return false;
        }
    }
}
