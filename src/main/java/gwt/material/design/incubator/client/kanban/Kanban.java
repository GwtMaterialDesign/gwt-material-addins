package gwt.material.design.incubator.client.kanban;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.kanban.js.JKanban;
import gwt.material.design.incubator.client.kanban.js.KanbanBoard;
import gwt.material.design.incubator.client.kanban.js.KanbanItem;
import gwt.material.design.incubator.client.kanban.js.KanbanOptions;

import java.util.Arrays;
import java.util.List;

/**
 * A Kanban Board implementation to easily build and organize your Board and it's Item.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://github.com/riktar/jkanban">Documentation</a>
 */
public class Kanban extends MaterialWidget implements JsLoader {

    private JKanban kanban;
    private KanbanOptions kanbanOptions = KanbanOptions.create();

    public Kanban() {
        super(Document.get().createDivElement());
    }

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesign.injectDebugJs(KanbanClientDebugBundle.INSTANCE.jkanbanJs());
            MaterialDesign.injectCss(KanbanClientDebugBundle.INSTANCE.jskanbanCss());
        } else {
            MaterialDesign.injectJs(KanbanClientBundle.INSTANCE.jkanbanJs());
            MaterialDesign.injectCss(KanbanClientBundle.INSTANCE.jskanbanCss());
        }
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    @Override
    public void load() {
        setId(DOM.createUniqueId());
        kanbanOptions = getOptions();
        kanbanOptions.setElement("#" + getId());
        kanban = new JKanban(getOptions());
    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

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
        kanban.addBoards(boards);
    }

    /**
     * Find board's item by id
     */
    public KanbanItem findItem(String id) {
        return kanban.findElement(id);
    }

    /**
     * Replace item by id with element JSON standard format
     */
    public void replaceItem(String id, KanbanItem element) {
        kanban.replaceElement(id, element);
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
}
