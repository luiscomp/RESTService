package br.com.eduardo.restservice.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.eduardo.restservice.R;
import br.com.eduardo.restservice.vo.ProdutoVO;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LuisEduardo on 26/04/2017.
 */
public class ProdutoRecycleViewAdapter extends RecyclerView.Adapter<ProdutoRecycleViewAdapter.ViewHolder> {

    private ArrayList<ProdutoVO> lista;

    public ProdutoRecycleViewAdapter() {
    }

    public void atualizarData(ArrayList<ProdutoVO> lista) {
        this.lista = lista;
        notifyDataSetChanged();
    }

    @Override
    public ProdutoRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_produtos, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProdutoRecycleViewAdapter.ViewHolder holder, int position) {
        holder.tvNome.setText(lista.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return lista == null ? 0 : lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvNome) TextView tvNome;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
