package com.stacks.bdd.utils;
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.PropertySet;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.search.FindItemsResults;
import microsoft.exchange.webservices.data.search.ItemView;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class EmailManager {
    private ExchangeService service;


    public EmailManager() throws URISyntaxException {
        service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
        ExchangeCredentials credentials;

        credentials = new WebCredentials("", "");


        service.setUrl(new URI(""));
        service.setCredentials(credentials);
    }

    public List<Item> getMessages() throws Exception {
        ItemView view = new ItemView(50);
        FindItemsResults<Item> results = service.findItems(WellKnownFolderName.Inbox, view);
        service.loadPropertiesForItems(results, PropertySet.FirstClassProperties);

        return results.getItems();
    }

    public Item getLastMessage() throws Exception {
        return getMessages().get(0);
    }

    public String getEmail() {
        return "";
    }
}
