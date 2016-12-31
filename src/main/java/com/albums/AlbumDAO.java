package com.albums;

import com.albums.Entity.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Вова on 30.12.2016.
 */
@Repository
public interface AlbumDAO extends CrudRepository<Album,Long> {
}
