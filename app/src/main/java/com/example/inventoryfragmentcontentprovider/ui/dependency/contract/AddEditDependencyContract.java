package com.example.inventoryfragmentcontentprovider.ui.dependency.contract;

import com.example.inventoryfragmentcontentprovider.ui.base.BasePresenter;
import com.example.inventoryfragmentcontentprovider.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddEditDependencyContract {
    interface View extends BaseView{
        void setNameError();
        void setShortnameError();
        void setDescriptionError();
        void setShortnameLenghtError();
        void showDependencyList();
        void showNameEmptyError();
        void showShortnameEmptyError();
        void showShortnameLenghtError();
        void showDescriptionEmptyError();
    }

    interface Presenter extends BasePresenter{
        void validateDependency(String name, String shortname, String description);
    }
}
