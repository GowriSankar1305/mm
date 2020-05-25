package com.jocata.vadin.ui.views;

import com.jocata.vadin.backend.entity.Company;
import com.jocata.vadin.backend.entity.Contact;
import com.jocata.vadin.backend.service.CompanyService;
import com.jocata.vadin.backend.service.ContactService;
import com.jocata.vadin.ui.ContactForm;
import com.jocata.vadin.ui.MainLayout;
import com.jocata.vadin.ui.ContactForm.CloseEvent;
import com.jocata.vadin.ui.ContactForm.DeleteEvent;
import com.jocata.vadin.ui.ContactForm.SaveEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "",layout = MainLayout.class )
@PageTitle("Contacts | Vaadin CRM")
public class ListView extends VerticalLayout {
	
	private final ContactForm form;
	private ContactService contactService;
	private static final long serialVersionUID = 7466179690179126063L;
	
	Grid<Contact> contacts = new Grid<>(Contact.class);
	TextField textField = new TextField();
	
	public ListView(ContactService contactService,CompanyService companyService) {
		
		this.form = new ContactForm(companyService.getAllCompanies());
		form.addListener(SaveEvent.class, this::saveContact);
		form.addListener(DeleteEvent.class, this::deleteContact);
		form.addListener(CloseEvent.class, e -> closeEditor());
		
		this.contactService = contactService;
		addClassName("list-view");
		setSizeFull();
		prepareGrid();
		getToolBar();
		
		Div content = new Div(contacts,form);
		content.addClassName("content");
		content.setSizeFull();
		
		add(getToolBar(),content);
		updateList();
		closeEditor();
    }

	public void saveContact(SaveEvent event) {
		contactService.saveContact(event.getContact());
		updateList();
		closeEditor();
	}
	
	public void deleteContact(DeleteEvent event)	{
		contactService.deleteContact(event.getContact());
		updateList();
		closeEditor();
	}
	private void closeEditor() {
		form.setContact(null);
		form.setVisible(false);
		removeClassName("editing");
	}

	private HorizontalLayout getToolBar() {
		textField.setPlaceholder("Filter by name...");
		textField.setClearButtonVisible(true);
		textField.setValueChangeMode(ValueChangeMode.LAZY);
		textField.addValueChangeListener(e -> updateList2());
		
		Button addButton = new Button("Add contact",click -> addContact());
		HorizontalLayout toolbar = new HorizontalLayout(textField,addButton);
		toolbar.addClassName("toolbar");
		return toolbar;
	}

	private void addContact() {
		contacts.asSingleSelect().clear();
		editContact(new Contact());
	}

	private void updateList() {
		contacts.setItems(contactService.getAllContacts());
	}
	
	private void updateList2()	{
		contacts.setItems(contactService.getAllContacts(textField.getValue()));
	}

	private void prepareGrid() {
		contacts.addClassName("contact-grid");
		contacts.setSizeFull();
		contacts.removeColumnByKey("company");
		contacts.setColumns("firstName","lastName","email","status");
		contacts.addColumn(contact -> {
			Company company = contact.getCompany();
			return company == null ? "-" : company.getName();
		}).setHeader("Company");
		
		contacts.getColumns().forEach(item -> {
			item.setAutoWidth(true);
		});
		
		contacts.asSingleSelect().addValueChangeListener(event -> editContact(event.getValue()));
	}

	private void editContact(Contact value) {
		if (value == null)	{
			closeEditor();
		}
		else	{
			form.setContact(value);
			form.setVisible(true);
			addClassName("editing");
		}
	}

}
