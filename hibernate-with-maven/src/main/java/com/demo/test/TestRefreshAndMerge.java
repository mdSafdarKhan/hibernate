package com.demo.test;

public class TestRefreshAndMerge {

	/*Refresh:
	 * Sometimes we face situation where application database is modified with some external 
	 * application/agent and thus corresponding hibernate entity in your application actually 
	 * becomes out of sync with it’s database representation i.e. having old data. In this case, 
	 * you can use session.refresh() method to re-populate the entity with latest data available in database.

		You can use one of the refresh() methods on the Session interface to refresh an instance of a persistent object, as follows:
			public void refresh(Object object) throws HibernateException
			public void refresh(Object object, LockMode lockMode) throws HibernateException
	 * 
	 * */
	
	/*Merge:
	 * Method merge() does exactly opposite to what refresh() does i.e. 
	 * It updates the database with values from a detached entity. 
	 * Refresh method was updating the entity with latest database information. 
	 * So basically, both are exactly opposite.

		Merging is performed when you desire to have a detached entity changed to persistent state again, 
		with the detached entity’s changes migrated to (or overriding) the database. 
		The method signatures for the merge operations are:

			Object merge(Object object)
			Object merge(String entityName, Object object)
	 * 
	 * */
}
