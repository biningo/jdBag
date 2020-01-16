package biningo.foreign_trade.service.impl;

import biningo.foreign_trade.entity.other.Poster;
import biningo.foreign_trade.repository.PosterRepository;
import biningo.foreign_trade.service.OtherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OtherServiceImpl implements OtherService {

    @Resource
    PosterRepository posterRepository;

    @Override
    public void SavePoster(Poster poster) {
        posterRepository.save(poster);
    }

    @Override
    public List<Poster> GetPoster() {
        return posterRepository.findAll();
    }
}
