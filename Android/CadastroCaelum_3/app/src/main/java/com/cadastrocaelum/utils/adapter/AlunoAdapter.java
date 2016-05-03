package com.cadastrocaelum.utils.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cadastrocaelum.R;
import com.cadastrocaelum.utils.pojo.Aluno;

import java.util.List;

/**
 * Created by Victor on 01/05/2016.
 */
//public class AlunoAdapter<T> extends BaseAdapter {
public class AlunoAdapter extends BaseAdapter {

    private Activity activty;
    private List<Aluno> listaAlunos;

    public AlunoAdapter(Activity activty, List<Aluno> listaAlunos) {
        this.activty = activty;
        this.listaAlunos = listaAlunos;
    }

    @Override
    public int getCount() {
        return listaAlunos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaAlunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaAlunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater= activty.getLayoutInflater();
        View linha = layoutInflater.inflate(R.layout.item, null);//segundo parametro serviria se ele estive dentro de outo inflate

        //lyout normal
        TextView nome = (TextView)linha.findViewById(R.id.nomeLista);
        ImageView foto = (ImageView) linha.findViewById(R.id.fotoLista);
        if(nome !=null) {
            nome.setText(listaAlunos.get(position).getNome());
            if (listaAlunos.get(position).getFoto() != null) {
                Bitmap imagem = BitmapFactory.decodeFile(listaAlunos.get(position).getFoto());
                Bitmap imagemReduzida = Bitmap.createScaledBitmap(imagem, 100, 100, true);
                foto.setImageBitmap(imagemReduzida);
            } else {
                foto.setImageResource(R.drawable.alura);
            }
        }

        //esse item existe apenas no landscape, pode até por o mesmo nomde de id para facilitar a vida
        ImageView txtFoto = (ImageView)linha.findViewById(R.id.land_fotoLista);
        TextView txtNome = (TextView)linha.findViewById(R.id.land_nomeLista);
        TextView txtSite = (TextView)linha.findViewById(R.id.land_siteLista);
        TextView txtTel = (TextView)linha.findViewById(R.id.land_telLista);
        if(txtTel != null){
            txtTel.setText(listaAlunos.get(position).getTelefone());
            txtNome.setText(listaAlunos.get(position).getNome());
            txtSite.setText(listaAlunos.get(position).getSite());
            txtTel.setText(listaAlunos.get(position).getTelefone());
            if(listaAlunos.get(position).getFoto() != null){
                Bitmap imagem = BitmapFactory.decodeFile(listaAlunos.get(position).getFoto());
                Bitmap imagemReduzida = Bitmap.createScaledBitmap(imagem, 100, 100, true);
                txtFoto.setImageBitmap(imagemReduzida);
            }else {
                txtFoto.setImageResource(R.drawable.alura);
            }
        }

        return linha;
    }
}
