package com.example.demo.ui;

import com.example.demo.backend.entity.Breakfast;
import com.example.demo.backend.service.BreakfastService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route("")
public class HomeView extends VerticalLayout {

    public HomeView(BreakfastService service){
        var crud = new GridCrud<>(Breakfast.class, service);

        crud.getGrid().setColumns("name","cpf","breakfastItem");
        crud.getCrudFormFactory().setVisibleProperties("name","cpf","breakfastItem");

        add(
                new H1("Breakfast List"),
                new H5("The Breakfast Item and CPF cannot be repeated and the CPF need 11 numbers!"),
                crud,
                new HorizontalLayout(
                        new Button("API Rest Page", ClickEvent -> UI.getCurrent().navigate("/api/rest")),
                        new Text("Click and reload the page.")
                )
        );
    }
}
