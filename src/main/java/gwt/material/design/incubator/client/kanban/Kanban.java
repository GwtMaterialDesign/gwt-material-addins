/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
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
package gwt.material.design.incubator.client.kanban;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.client.theme.dark.DarkThemeLoader;
import gwt.material.design.incubator.client.kanban.js.JKanban;
import gwt.material.design.incubator.client.kanban.js.KanbanBoard;
import gwt.material.design.incubator.client.kanban.js.KanbanItem;
import gwt.material.design.incubator.client.kanban.js.KanbanOptions;
import gwt.material.design.incubator.client.kanban.util.KanbanResponsiveLoader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static gwt.material.design.jquery.client.api.JQuery.$;

/**
 * A Kanban Board implementation to easily build and organize your Board and it's Item.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://github.com/riktar/jkanban">Documentation</a>
 */
public class Kanban extends AbstractAddinsWidget {

    private boolean responsive = true;
    private JKanban kanban;
    private KanbanOptions kanbanOptions = KanbanOptions.create();
    private KanbanResponsiveLoader responsiveLoader;
    private List<KanbanBoard> boards;

    public Kanban() {
        super(Document.get().createDivElement(), "kanban");

        responsiveLoader = new KanbanResponsiveLoader(this);
    }

    @Override
    protected void internalLoad() {
        setId(DOM.createUniqueId());
        kanbanOptions = getOptions();
        kanbanOptions.setElement("#" + getId());
        kanban = new JKanban(getOptions());

        if (responsive) {
            responsiveLoader.load();
        } else {
            responsiveLoader.unload();
        }
    }

    /**
     * Sets the options to be used on Kanban
     */
    public void setOptions(KanbanOptions kanbanOptions) {
        this.kanbanOptions = kanbanOptions;
    }

    public KanbanOptions getOptions() {
        return kanbanOptions;
    }

    /**
     * Add KanbanItem in the board with ID boardID, item is the standard format
     */
    public void addItem(String boardId, KanbanItem item) {
        kanban.addElement(boardId, item);
    }

    /**
     * Add formItem as html element into the board with ID boardID
     */
    public void addForm(String boardId, Element formElement) {
        kanban.addForm(boardId, formElement);
    }

    /**
     * Add one or more boards in the kanban, boards are in the standard format
     */
    public void addBoards(KanbanBoard... boards) {
        this.boards = Arrays.asList(boards);
        kanban.addBoards(boards);
    }

    /**
     * Find board's item by id
     */
    public KanbanItem findItem(String id) {
        return kanban.findElement(id);
    }

    /**
     * Returns the DOM element of an item
     */
    public Element findElementItem(KanbanItem item) {
        return $(".kanban-item[data-eid='" + item.getDataset().getId() + "']").asElement();
    }

    /**
     * Replace item by id with element JSON standard format
     */
    public void replaceItem(String id, KanbanItem element) {
        kanban.replaceElement(id, element);
    }

    public void moveItem(KanbanItem currentItem, String boardId) {
        KanbanItem newItem = new KanbanItem();
        newItem.setId(currentItem.getDataset().getId());
        newItem.setTitle(currentItem.getInnerHTML());
        removeItem(currentItem.getDataset().getId());
        addItem(boardId, newItem);
    }

    /**
     * Get board ID of item id passed
     */
    public String getParentBoardID(String id) {
        return kanban.getParentBoardID(id);
    }

    /**
     * Find board by id
     */
    public KanbanBoard findBoard(String id) {
        return kanban.findBoard(id);
    }

    /**
     * Get all item of a board
     */
    public List<KanbanItem> getAllBoardItems(String id) {
        return Arrays.asList(kanban.getBoardElements(id));
    }

    public List<KanbanBoard> getAllBoards() {
        return boards;
    }

    /**
     * Remove a board's element by id
     */
    public void removeItem(String id) {
        kanban.removeElement(id);
    }

    /**
     * Remove a board by id
     */
    public void removeBoard(String id) {
        kanban.removeBoard(id);
    }

    /**
     * Clear all the boards
     */
    public void clearAllBoards() {
        if (boards != null) {
            boards.forEach(kanbanBoard -> removeBoard(kanbanBoard.getId()));
        }
    }

    /**
     * Will enable / disable Mobile Responsive support
     */
    public void setResponsive(boolean responsive) {
        this.responsive = responsive;
    }

    public boolean isResponsive() {
        return responsiveLoader.isResponsive();
    }

    @Override
    public Class<? extends DarkThemeLoader> getDarkTheme() {
        return KanbanDarkTheme.class;
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(KanbanClientBundle.INSTANCE.jskanbanCss(), KanbanClientDebugBundle.INSTANCE.jskanbanCss()));
    }

    @Override
    public List<DependencyResource> getJsDependencies() {
        return Collections.singletonList(new DependencyResource(KanbanClientBundle.INSTANCE.jkanbanJs(), KanbanClientDebugBundle.INSTANCE.jkanbanJs()));
    }
}
