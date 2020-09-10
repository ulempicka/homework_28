package pl.javastart.sellegro.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pl.javastart.sellegro.model.Auction;

import java.util.List;

@Service
public interface AuctionService extends JpaRepository<Auction, Long> {

    @Query(value = "SELECT * FROM auctions ORDER BY price DESC LIMIT 4", nativeQuery = true)
    List<Auction> find4MostExpensive();

    @Query(value = "SELECT * FROM auctions WHERE :column LIKE filter%", nativeQuery = true)
    List<Auction> findAllForFilters(String column, String filter);

    @Query("SELECT a FROM Auction a ORDER BY :column")
    List<Auction> findAllSorted(String column);
}
