package com.jocata.vadin.ui;

import java.util.List;

import com.jocata.vadin.backend.entity.Company;
import com.jocata.vadin.backend.entity.Contact;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;

public class ContactForm extends FormLayout {

	private static final long serialVersionUID = 4266008961532510648L;
	
	TextField firstName = new TextField("First Name");
	TextField lastName = new TextField("Last Name");
	EmailField email = new EmailField("Email");
	ComboBox<Contact.Status> status = new ComboBox<Contact.Status>("Status");
	ComboBox<Company> company = new ComboBox<Company>("Company");
	
	Button saveBtn = new Button("Save");
	Button deleteBtn = new Button("Delete");
	Button closeBtn = new Button("Close");
	
	// data binfing
	Binder<Contact> binder = new BeanValidationBinder<>(Contact.class);
	
	public ContactForm(List<Company> companies)	{
		binder.bindInstanceFields(this);
		status.setItems(Contact.Status.values());
		company.setItems(companies);
		company.setItemLabelGenerator(Company::getName);
		addClassName("contact-form");
		add(firstName,lastName,email,status,company,createButtonsLayuot());
	}
	
	public void setContact(Contact contact) {
		  binder.setBean(contact); 
	}
	
	private Component createButtonsLayuot() {
		
		saveBtn.addClickListener(listener -> validateAndSave());
		deleteBtn.addClickListener(listener -> fireEvent(new DeleteEvent(this, binder.getBean())));
		closeBtn.addClickListener(listener -> fireEvent(new CloseEvent(this)));
		
		// adding themes to buttons for look and feel
		saveBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		deleteBtn.addThemeVariants(ButtonVariant.LUMO_ERROR);
		closeBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
		
		// adding keyboard shortcuts for buttons
		saveBtn.addClickShortcut(Key.ENTER);
		closeBtn.addClickShortcut(Key.ESCAPE);
		
		// disabling save button is form is invalid
		binder.addStatusChangeListener(evt -> saveBtn.setEnabled(binder.isValid()));
		
		return new HorizontalLayout(saveBtn,deleteBtn,closeBtn);
	}
	
	private void validateAndSave() {
		if (binder.isValid())	{
			fireEvent(new SaveEvent(this, binder.getBean()));
		}
	}

	// Events
	public static abstract class ContactFormEvent extends ComponentEvent<ContactForm> {
	  private Contact contact;

	  protected ContactFormEvent(ContactForm source, Contact contact) { 
	    super(source, false);
	    this.contact = contact;
	  }

	  public Contact getContact() {
	    return contact;
	  }
	}

	public static class SaveEvent extends ContactFormEvent {
	  SaveEvent(ContactForm source, Contact contact) {
	    super(source, contact);
	  }
	}

	public static class DeleteEvent extends ContactFormEvent {
	  DeleteEvent(ContactForm source, Contact contact) {
	    super(source, contact);
	  }

	}

	public static class CloseEvent extends ContactFormEvent {
	  CloseEvent(ContactForm source) {
	    super(source, null);
	  }
	}

	public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
	    ComponentEventListener<T> listener) { 
	  return getEventBus().addListener(eventType, listener);
	}
}
