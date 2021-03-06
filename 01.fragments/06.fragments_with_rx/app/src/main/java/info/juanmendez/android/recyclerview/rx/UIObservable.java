package info.juanmendez.android.recyclerview.rx;

import info.juanmendez.android.recyclerview.model.Country;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/**
 * Created by Juan on 10/25/2015.
 */
public class UIObservable
{
    BehaviorSubject subject;
    SubscriptionHandler handler;
    Country lastCountry;

    public UIObservable(){
        subject = BehaviorSubject.create();
        handler = new SubscriptionHandler( subject );
    }

    public void emit( Country country ){

        if( country != null ){
            lastCountry = country;
            subject.onNext( country );
        }
    }

    public Country getCountry(){
        return this.lastCountry;
    }

    public Subscription subscribe( Action1<Country> observer ){
        return handler.subscribe( observer );
    }

    public void unsubscribe( Subscription subscription ){
        handler.unsubscribe( subscription );
    }
}
