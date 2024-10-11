package it.apuliadigital.albumApi.service;

import it.apuliadigital.albumApi.model.Album;

import java.util.List;

public interface AlbumService {
    Album getAlbumById(Long idAlbum);
    Album createAlbum(Album album);
    boolean updateAlbum(Long id, Album album);
    boolean deleteAlbum(Long id);
    List<Album> searchAlbums(String title, String author);
}
