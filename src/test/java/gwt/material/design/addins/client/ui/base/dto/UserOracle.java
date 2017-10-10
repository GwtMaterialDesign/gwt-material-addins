package gwt.material.design.addins.client.ui.base.dto;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import gwt.material.design.addins.client.autocomplete.base.MaterialSuggestionOracle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserOracle extends MaterialSuggestionOracle {

    private List<User> contacts = new LinkedList<>();

    public void addContacts(List<User> users) {
        contacts.addAll(users);
    }

    @Override
    public void requestSuggestions(Request request, Callback callback) {
        Response resp = new Response();
        if (contacts.isEmpty()) {
            callback.onSuggestionsReady(request, resp);
            return;
        }
        String text = request.getQuery();
        text = text.toLowerCase();

        List<UserSuggestion> list = new ArrayList<>();

        for (User contact : contacts) {
            if (contact.getValue().toLowerCase().contains(text)) {
                list.add(new UserSuggestion(contact));
            }
        }

        resp.setSuggestions(list);
        callback.onSuggestionsReady(request, resp);
    }
}