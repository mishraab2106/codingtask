package com.project.codingtask.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.codingtask.entity.ENewspaperModel;

@Repository
public interface DbRepository extends JpaRepository<ENewspaperModel,String> {
	
@Query(value = "select * from enewspaper where newspaperName iLIKE CONCAT ('%',:newspaperName,'%') ORDER BY sort offset :offset rows fetch next :pagesize rows only",nativeQuery = true)
List<ENewspaperModel> paginationSortingFilter(@Param("newspaperName")String newspaperName,
		                                      @Param("offset")int offset,@Param("pagesize")int pagesize);

	
Page<ENewspaperModel> findBynewspapernameContainingIgnoreCase(String newspapername, Pageable pageable);

Page<ENewspaperModel> findByuploadtimeContainingIgnoreCase(String uploadtime, Pageable pageable);
Page<ENewspaperModel> findByfilenameContainingIgnoreCase(String filename, Pageable pageable);
}
