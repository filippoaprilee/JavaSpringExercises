package it.apuliadigital.albumApi.service.impl;

import it.apuliadigital.albumApi.entity.AlbumEntity;
import it.apuliadigital.albumApi.entity.GenereEnum;
import it.apuliadigital.albumApi.model.Album;
import it.apuliadigital.albumApi.repository.AlbumRepository;
import it.apuliadigital.albumApi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public Album getAlbumById(Long idAlbum) {
        Optional<AlbumEntity> entity = albumRepository.findById(idAlbum);

        Album a = new Album();
        a.setIdAlbum(idAlbum);
        a.setTitle(entity.get().getTitle());
        a.setAuthor(entity.get().getAuthor());
        a.setGenere(Album.GenereEnum.valueOf(entity.get().getGenere().name()));

        return a;
    }

    @Override
    public Album createAlbum(Album album) {
        AlbumEntity entity = new AlbumEntity();
        entity.setTitle(album.getTitle());
        entity.setAuthor(album.getAuthor());
        entity.setGenere(GenereEnum.valueOf(album.getGenere().name()));
        entity.setRelease_year(album.getYear());
        albumRepository.save(entity);
        return album;
    }

    @Override
    public boolean updateAlbum(Long id, Album album) {
        if (albumRepository.existsById(id)) {
            AlbumEntity entity = new AlbumEntity();
            entity.setIdAlbum(id);
            entity.setTitle(album.getTitle());
            entity.setAuthor(album.getAuthor());
            entity.setGenere(GenereEnum.valueOf(album.getGenere().name()));
            entity.setRelease_year(album.getYear());
            albumRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAlbum(Long id) {
        if (albumRepository.existsById(id)) {
            albumRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Album> searchAlbums(String title, String author, GenereEnum genre) {
        List<AlbumEntity> entities = albumRepository.findByTitleAndAuthorAndGenere(title, author, genre);
        List<Album> albums = null;
        for (AlbumEntity entity : entities) {
            Album a = new Album();
            a.setIdAlbum(entity.getIdAlbum());
            a.setTitle(entity.getTitle());
            a.setAuthor(entity.getAuthor());
            a.setGenere(Album.GenereEnum.valueOf(entity.getGenere().name()));
            albums.add(a);
        }
        return albums;
    }
}
