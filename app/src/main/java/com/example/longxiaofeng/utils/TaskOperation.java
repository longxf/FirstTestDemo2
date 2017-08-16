package com.example.longxiaofeng.utils;

/*
 * Copyright (C) 2016 Baidu Inc. All rights reserved.
 */

import java.util.ArrayList;

/**
 * The task operation, it wraps the task parameter, etc.
 *
 * @author Li Hong
 * @since 2012/10/30
 */
public class TaskOperation {
    /**
     * The task parameter.
     */
    private Object[] mNextTaskParams = null;

    /**
     * The task manager status.
     */
    private TaskManager.TaskManagerState mTaskManagerStatus = TaskManager.TaskManagerState.CONTINUE;

    /**
     * The constructor method.
     */
    public TaskOperation() {
    }

    /**
     * The constructor method.
     *
     * @param nextTaskParams paramter
     */
    public TaskOperation(Object[] nextTaskParams) {
        mNextTaskParams = nextTaskParams;
    }

    /**
     * The constructor method.
     *
     * @param operation operation
     */
    public TaskOperation(TaskOperation operation) {
        setTaskParams(operation);
    }

    /**
     * Get the task parameter.
     *
     * @return parameters
     */
    public Object[] getTaskParams() {
        return mNextTaskParams;
    }

    /**
     * Set parameter to empty
     */
    public void setTaskParamsEmpty() {
        mNextTaskParams = null;
    }

    /**
     * Set the task parameter.
     *
     * @param params params
     */
    public void setTaskParams(Object[] params) {
        mNextTaskParams = params;
    }

    /**
     * Set the task parameters.
     *
     * @param operation operation
     */
    public void setTaskParams(TaskOperation operation) {
        if (operation == this) {
            throw new IllegalArgumentException("The argument can NOT be self.");
        }

        if (null == operation) {
            return;
        }

        Object[] params = operation.getTaskParams();
        if (null == params) {
            return;
        }

        ArrayList<Object> paramsList = new ArrayList<Object>();

        if (null != mNextTaskParams) {
            for (Object param : mNextTaskParams) {
                paramsList.add(param);
            }
        }

        for (Object param : params) {
            paramsList.add(param);
        }

        mNextTaskParams = paramsList.toArray();
    }

    /**
     * @param status the mTaskManagerStatus to set
     */
    public void setTaskManagerStatus(TaskManager.TaskManagerState status) {
        mTaskManagerStatus = status;
    }

    /**
     * @return the mTaskManagerStatus
     */
    public TaskManager.TaskManagerState getTaskManagerStatus() {
        return mTaskManagerStatus;
    }

    /**
     * Append the specified parameter to the end of the parameter list.
     *
     * @param param param
     */
    public void appendTaskParam(Object param) {
        appendTaskParams(new Object[]{param});
    }

    /**
     * Append the specified parameter to the end of the parameter list.
     *
     * @param params params
     */
    public void appendTaskParams(Object[] params) {
        if (null != params) {
            TaskOperation operation = new TaskOperation(params);
            setTaskParams(operation);
        }
    }
}
