package android.example.myapplication.common.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T : ViewDataBinding>(
    binding: T
) : RecyclerView.ViewHolder(binding.root)
