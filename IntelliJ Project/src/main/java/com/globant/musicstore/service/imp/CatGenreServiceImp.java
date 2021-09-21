package com.globant.musicstore.service.imp;

import com.globant.musicstore.dao.CatGenreDAO;
import com.globant.musicstore.dto.requestDTO.CatGenreDTO;
import com.globant.musicstore.entity.CatGenre;
import com.globant.musicstore.exception.InvalidDataException;
import com.globant.musicstore.exception.ModelNotFoundException;
import com.globant.musicstore.service.CatGenreService;
import com.globant.musicstore.utils.mapper.CatGenreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatGenreServiceImp implements CatGenreService {

    @Autowired
    private CatGenreDAO catGenreDAO;

    @Autowired
    private CatGenreMapper catGenreMapper;

    @Override
    public List<CatGenreDTO> getAllGenres() {
        return catGenreMapper.listGenreToDTO(catGenreDAO.findAll());
    }

    @Override
    public CatGenreDTO saveGenre(CatGenreDTO catGenreDTO) {
        validationInputFromUser(catGenreDTO);
        return catGenreMapper.genreToDto(catGenreDAO.save(catGenreMapper.genreDTOToGenre(catGenreDTO)));
    }

    @Override
    public CatGenreDTO updateGenre(long genreId, CatGenreDTO catGenreDTO) {
        CatGenreDTO getGenreById = getGenreById(genreId);
        validationInputFromUser(catGenreDTO);
        catGenreDTO.setId(genreId);
        return catGenreMapper.genreToDto(catGenreDAO.save(catGenreMapper.genreDTOToGenre(catGenreDTO)));
    }

    @Override
    public CatGenreDTO deleteGenreLogically(long catGenreId) {
        CatGenreDTO getGenreById = getGenreById(catGenreId);
        getGenreById.setActive(false);

        return catGenreMapper.genreToDto(catGenreDAO.save(catGenreMapper.genreDTOToGenre(getGenreById)));
    }

    @Override
    public CatGenreDTO getGenreById(long catGenreId) {
        CatGenre findGenreById = catGenreDAO.findById(catGenreId).orElseThrow(() -> new ModelNotFoundException("no existe"));
        return catGenreMapper.genreToDto(findGenreById);
    }

    public void validationInputFromUser(CatGenreDTO catGenreDTO) {
        if (catGenreDTO.getName().isEmpty() || catGenreDTO.getDescription().isEmpty()) {
            throw new InvalidDataException("error input");
        }
    }
}
