package pl.javastart.sellegro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.sellegro.model.Auction;
import pl.javastart.sellegro.service.AuctionService;

import java.util.List;

@Controller
public class AuctionController {

    private AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("cars", auctionService.find4MostExpensive());
        return "home";
    }

    @GetMapping("/auctions")
    public String auctions(Model model,
                           @RequestParam(required = false) String column, @RequestParam(required = false) String filter) {
        List<Auction> auctions;
        if(column != null) {
            auctions = auctionService.findAllSorted(column);
        } else {
            auctions = auctionService.findAllForFilters(column,filter);
        }

        model.addAttribute("auctions", auctions);
        return "auctions";
    }
}
