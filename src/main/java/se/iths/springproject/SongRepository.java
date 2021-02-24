package se.iths.springproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Crud repository är ett färdigbyggt interface, men vi kan utöka funktionallitet genom att lägga till metoder här

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

    //En repository kan vara ansluten till flera dao objekt samtidigt och ger funktioner som ger känslan av
    //att det är en collection vi jobbar med och inte en databas

    //Genom att namnge metoden rätt så skapas automatiskt en sql-fråga
    List<Song> findAllByTitle(String title);

}
