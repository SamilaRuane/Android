package ui;

import business.PostBusiness;
import entity.PostEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PostListForm extends JFrame implements ListSelectionListener {
    private JTable tablePost;
    private JPanel panel1;
    private PostBusiness mPostBusiness = new PostBusiness();

    public PostListForm(){
        super();

        this.getAllPosts();
        this.setContentPane(panel1);
        this.setSize(250, 250);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setEvents ();

    }

    private void getAllPosts (){

        int i = 0;
        String[] columnNames = {"Id", "Título"};
        List<PostEntity> lst = this.mPostBusiness.getAllPosts();

        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);
        for (PostEntity entity:lst){
            Object[] o = new Object[2];
            o[0] = entity.getId();
            o[1] = entity.getTitle();

            model.addRow(o);

            i++;
           if (i >= 10){
               break;
           }

           this.tablePost.setModel(model);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {

        int postId;
        if(listSelectionEvent.getValueIsAdjusting()){
           postId = Integer.parseInt(tablePost.getValueAt(tablePost.getSelectedRow(), 0).toString());
           new PostDetailForm(postId);
        }
    }

    private void setEvents (){
        tablePost.getSelectionModel().addListSelectionListener(this);
    }


}
