package org.example.oopDeepDive.ex2;

import org.example.oopDeepDive.ex1.BaseInventoryItem;
import org.example.oopDeepDive.ex3.Validator;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

public class Warehouse {
    protected static final List<BaseInventoryItem> _inventory =  new ArrayList<>();
    private String _name = "";
    private String _location = "";
    private AuditManager _auditManager = new AuditManager();

    public Warehouse(String name, String location) {
        _name = name;
        _location = location;
    }

    public String getLocation() {
        return _location;
    }
    public void setLocation(String location) {

        _location = location;
    }
    public String getName() {
        return _name;
    }
    public void setName(String name) {

        _name = name;
    }

    public BaseInventoryItem getItemByName(String name) {
        for (BaseInventoryItem item : _inventory) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public  void addItem(BaseInventoryItem item)  {
        item.setId(_inventory.size());
        _auditManager.addItem(item);
    }


    public Iterator<StoreItem> getAuditInfo(int id) {
        return _auditManager.getAuditInfo(id);
    }

    public Iterator<BaseInventoryItem> getItems() {
        return _inventory.iterator();
    }
    protected boolean validateInput(BaseInventoryItem inventoryItem, Predicate<BaseInventoryItem> rule){
        return  new Validator.BasicValidator().isValidate(inventoryItem, rule);
    }

    //Inner class
    public class AuditManager{
        private Map<Integer, Set<StoreItem>> _auditInfo = new HashMap<>();

        private void addItem(BaseInventoryItem item) {
            if(!_auditInfo.containsKey(item.getId())) {
                _auditInfo.put(item.getId(), new HashSet<>());
            }

            _auditInfo.get(item.getId()).add(new StoreItem("add", LocalDateTime.now(Clock.systemUTC()), "me"));
            _inventory.add(item);
        }

        private void removeItem(int id) {
            if(!_auditInfo.containsKey(id)) {
                return;
            }
            _auditInfo.get(id).add(new StoreItem("delete", LocalDateTime.now(Clock.systemUTC()), "me"));
            _inventory.remove(id);
        }

        private void updateItem(BaseInventoryItem item) {
            if(!_auditInfo.containsKey(item.getId())) {
                return;
            }
            
            _auditInfo.get(item.getId()).add(new StoreItem("update", LocalDateTime.now(Clock.systemUTC()), "me"));
            _inventory.remove(item.getId());
            _inventory.add(item);
        }

        public Iterator<StoreItem> getAuditInfo(int id){
            return _auditInfo.get(id).iterator();
        }

    }

    public record StoreItem(String action, LocalDateTime dateTime,  String actor) { }
}
