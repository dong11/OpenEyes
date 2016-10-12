package com.rex.hwong.openeyes.ui.widget.tagview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TagView extends TextView {
	
	public TagView(Context paramContext) {
		super(paramContext);
		init();
	}

	public TagView(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
		init();
	}

	public TagView(Context paramContext, AttributeSet paramAttributeSet,
			int paramInt) {
		super(paramContext, paramAttributeSet, 0);
		init();
	}

	private void init() {
		setText("");
		setBackgroundColor(0x99cccccc);
	}
}
