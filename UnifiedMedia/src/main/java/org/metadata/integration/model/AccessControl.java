package org.metadata.integration.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class AccessControl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<String> Admin;

    @ElementCollection
    private List<String> Viewer;

    public List<String> getEditor() {
        return Editor;
    }

    public List<String> getViewer() {
        return Viewer;
    }

    public void setViewer(List<String> viewer) {
        Viewer = viewer;
    }

    public void setEditor(List<String> editor) {
        Editor = editor;
    }

    public List<String> getAdmin() {
        return Admin;
    }

    public void setAdmin(List<String> admin) {
        Admin = admin;
    }
    @ElementCollection
    private List<String> Editor;
}
