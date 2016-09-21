package gwt.material.design.addins.client;

import gwt.material.design.addins.client.autocomplete.MaterialAutoComplete;
import gwt.material.design.addins.client.base.GwtMaterialAddinsTest;
import gwt.material.design.addins.client.base.User;
import gwt.material.design.addins.client.base.UserOracle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AutocompleteTest extends GwtMaterialAddinsTest {


    @Test
    public void testAutocomplete() {
        MaterialAutoComplete autoComplete = new MaterialAutoComplete();
        checkPlaceholder(autoComplete);
        checkValue(autoComplete);
    }

    public <T extends MaterialAutoComplete> void checkValue(T widget) {
        UserOracle oracle = new UserOracle();
        oracle.addContacts(getAllUsers());
        widget.setSuggestions(oracle);
        List<String> itemValues = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            itemValues.add("Item " + i);
        }
        widget.setItemValues(itemValues);
        assertEquals(widget.getItemValues().size(), 3);
        widget.clear();
        assertEquals(widget.getItemValues().size(), 0);
        widget.setLimit(2);
        assertEquals(widget.getLimit(), 2);
    }

    public <T extends MaterialAutoComplete> void checkPlaceholder(T widget) {
        widget.setPlaceholder("test");
        assertEquals(widget.getPlaceholder(), "test");
    }

    protected List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            users.add(new User("User " + i));
        }
        return users;
    }
}
