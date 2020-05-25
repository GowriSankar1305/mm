package com.jocata.vadin.ui;

import com.jocata.vadin.ui.views.DashBoardView;
import com.jocata.vadin.ui.views.ListView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout {
	
	public MainLayout()	{
		createHeader();
		createSideBar();
	}

	private void createSideBar() {
		RouterLink link1 = new RouterLink("List",ListView.class);
		RouterLink link2 = new RouterLink("Dashboard",DashBoardView.class);
		link1.setHighlightCondition(HighlightConditions.sameLocation());
		link2.setHighlightCondition(HighlightConditions.sameLocation());
		addToDrawer(new VerticalLayout(link1,link2));
	}

	private void createHeader() {
		H1 logo = new H1("Vaadin CRM");
		logo.addClassName("logo");
		HorizontalLayout header = new HorizontalLayout(new DrawerToggle(),logo);
		header.addClassName("header");
		header.setWidth("100%");
		header.setDefaultVerticalComponentAlignment(Alignment.CENTER);
		addToNavbar(header);
	}
}
