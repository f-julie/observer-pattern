package observerpattern;

import java.util.ArrayList;

public class Service implements Subject {
    private ArrayList<Movie> movies;
    private ArrayList<Observer> subscribers; // Will actually be populated with subscriber objects

    public Service() {
        movies = new ArrayList<>();
        subscribers = new ArrayList<>();
    }

    @Override
    public void attach(Observer o) {
        subscribers.add(o);
    }

    @Override
    public void detach(Observer o) {
        subscribers.remove(o);
    }

    @Override
    public void updateAll() { // This method will be called as a result of state change
        for (Observer o : subscribers) {
            o.update();
        }
    }

    public void addMovie(Movie m) {
        movies.add(m);
        updateAll(); // Triggers notification for all subscriber objects
    }

    public void removeMovie(Movie m) {
        movies.remove(m);
        updateAll(); // Triggers notification for all subscriber objects
    }

    public ArrayList<Movie> getMovies() {
        return movies; // No need to notify when we're just reading the list of movies
    }
}
