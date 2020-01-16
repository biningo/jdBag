package biningo.foreign_trade.service;

import biningo.foreign_trade.entity.other.Poster;

import java.util.List;

public interface OtherService {

    void SavePoster(Poster poster);
    List<Poster> GetPoster();

}
