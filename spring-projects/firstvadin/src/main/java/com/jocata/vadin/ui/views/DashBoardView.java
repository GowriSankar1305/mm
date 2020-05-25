package com.jocata.vadin.ui.views;

import java.util.Map;

import com.jocata.vadin.backend.service.CompanyService;
import com.jocata.vadin.backend.service.ContactService;
import com.jocata.vadin.ui.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "dashboard",layout = MainLayout.class)
@PageTitle("Dashboard | Vaadin CRM")
public class DashBoardView extends VerticalLayout {
	
	private ContactService contactService;
	private CompanyService companyService;
	
	public DashBoardView(ContactService contactService,CompanyService companyService)	{
		this.contactService = contactService;
		this.companyService = companyService;
		
		addClassName("dashboard-view");
		setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		
		add(getContactStatus(),getCompaniesChart());
	}

	private Component getCompaniesChart() {
		Chart chart = new Chart(ChartType.PIE);
		DataSeries dataSeries = new DataSeries();
		Map<String,Integer> stats = companyService.getCompanyStats();
		stats.forEach((name,count) -> {
			dataSeries.add(new DataSeriesItem(name, count));
		});
		chart.getConfiguration().setSeries(dataSeries);
		return chart;
	}

	private Component getContactStatus() {
		Span span = new Span(contactService.getNoOfContacts()+" contacts");
		span.addClassName("contact-stats");
		return span;
	}
}
