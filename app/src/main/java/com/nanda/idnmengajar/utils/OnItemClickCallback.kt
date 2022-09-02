package com.nanda.idnmengajar.utils

import com.nanda.idnmengajar.data.entity.Notes

interface OnItemClickCallback {
    fun onItemClicked(notes: Notes)
}