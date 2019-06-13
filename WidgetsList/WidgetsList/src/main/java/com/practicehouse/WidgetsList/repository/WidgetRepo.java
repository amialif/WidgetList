package com.practicehouse.WidgetsList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practicehouse.WidgetsList.model.Widget;

@Repository
public interface WidgetRepo extends JpaRepository<Widget, Long>  {

}
