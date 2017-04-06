package com.example.khanh.foody4;

import android.app.Dialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;

/**
 * Created by Khanh on 4/3/2017.
 */

public class Create_plus extends BottomSheetDialogFragment
{
    //hàm này gọi activity tương ứng khi nhấn vào dấu cộng góc phải

    public void setupDialog(final Dialog dialog, int style)
    {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.layout_plus, null);
        dialog.setContentView(contentView);
    }
}
