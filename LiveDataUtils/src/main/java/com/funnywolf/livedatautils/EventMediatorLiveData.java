package com.funnywolf.livedatautils;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

/**
 * 用作事件传递的 {@link MediatorLiveData}
 *
 * @see AsEventBus
 *
 * @author funnywolf
 * @since 2019-05-18
 */
public class EventMediatorLiveData<T> extends MediatorLiveData<T> {
    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
        LiveEventObserver.bind(this, owner, observer);
    }

    @Override
    public void postValue(T value) {
        LiveDataUtils.setValue(this, value);
    }
}
